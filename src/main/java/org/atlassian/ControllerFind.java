package org.atlassian;

import java.util.*;

public class ControllerFind {
    PrefixNode root;
    static class PrefixNode{
        boolean isController;
        Map<String, PrefixNode> children;
        String controllerName;

        public PrefixNode() {
            this.isController = false;
            this.children = new HashMap<>();
        }
        public void setController(String controllerName){
            if(this.isController) throw new IllegalStateException("controller already exists");
            this.isController = true;
            this.controllerName = controllerName;
        }
    }

    public ControllerFind() {
        this.root = new PrefixNode();
    }

    void insertController(String path, String controllerName){
        var curr = root;
        var s = splitPath(path);
        for(String currPath: s){
            var m = curr.children;
            if(!m.containsKey(currPath)){
                m.put(currPath, new PrefixNode());
            }
            curr = m.get(currPath);
        }
        curr.setController(controllerName);
    }
    Optional<String> searchController(String path){
        var curr = root;
        for(String currPath: splitPath(path)){
            var m = curr.children;
            if(!m.containsKey(currPath)){
               return Optional.empty();
            }
            curr = m.get(currPath);
        }
        return Optional.ofNullable(curr.controllerName);
    }

    private List<String> splitPath(String path){
        return Arrays.stream(path.split("/")).filter(p -> !p.isBlank()).toList();
    }

    public static void main(String[] args) {
        var f = new ControllerFind();
        var path = "/this/is/test";
        f.insertController("/this/is/test", "naveen.class");
        //f.insertController("/this/is/test", "naveen.class");
        f.insertController("/this/is/test1", "naveen1.class");
        f.insertController("/this/is", "naveen3.class");

        System.out.println(f.searchController("/this/is/test1"));
        System.out.println(f.searchController("/this//is"));
        System.out.println(f.searchController("/this/is/test1/test2"));
        System.out.println(f.searchController("//"));
    }
}
