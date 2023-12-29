package org.hashing;

import java.util.*;

public class Manager {
    Map<String, Integer> subordinates;
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        Manager m = new Manager();
        //m.buildHierarchy(dataSet);
        //m.subordinates.forEach((k,v) -> System.out.println(k + ":"+v));
        m.findAllSubordinates(dataSet).forEach((k,v) -> System.out.println(k + ":"+v));
    }

    private  Queue<String> findLowest(Map<String, String> dict){
        Set<String> employees = new HashSet<>(dict.values());
        Queue<String> rem = new LinkedList<>();
        for(String c : dict.keySet()){
            if(!employees.contains(c)){
                rem.offer(c);
                subordinates.put(c, 0);
            }
        }
        return rem;
    }

    private void buildHierarchy(Map<String, String> dict){
        subordinates = new HashMap<>();
        Queue<String> rem = findLowest(dict);

        while(!rem.isEmpty()){
            String curr = rem.poll();
            Integer currCnt = subordinates.get(curr);
            String manager = dict.get(curr);
            int managerCnt = subordinates.computeIfAbsent(manager, (k) -> {
                rem.offer(manager);
                return currCnt;
            });
            subordinates.put(manager, managerCnt +1);
        }
    }

    public Map<String, Integer> findAllSubordinates(Map<String, String> dict){
        var managerToEmployeeMap = findSubordinates(dict);
        return calculateDescendants(managerToEmployeeMap);
    }
    private Map<String, Integer> calculateDescendants(Map<String, List<String>> managerToEmployeeMap){
        subordinates = new HashMap<>();
        for(String manager : managerToEmployeeMap.keySet()){
            int cnt  = cntDescendants(manager, managerToEmployeeMap);
            subordinates.put(manager, cnt);
        }
        return subordinates;
    }
    private int cntDescendants(String m, Map<String, List<String>> managerToEmployeeMap){
        List<String>  employees = managerToEmployeeMap.get(m);
        System.out.println(m);
        if(employees == null) return 0;
        return employees.size() + employees.stream().filter(s -> !Objects.equals(s, m)).map(s -> cntDescendants(s, managerToEmployeeMap)).reduce(0, Integer::sum);
    }

    private Map<String, List<String>> findSubordinates(Map<String, String> dict){
        Map<String, List<String>> managerToEmployeeMap = new HashMap<>();
        for(String sub: dict.keySet()){
            String manager = dict.get(sub);
            List<String> s = managerToEmployeeMap.computeIfAbsent(manager, k -> new LinkedList<>());
            s.add(sub);
        }
        return managerToEmployeeMap;
    }
}
