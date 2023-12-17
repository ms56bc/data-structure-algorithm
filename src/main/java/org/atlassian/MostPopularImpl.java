package org.atlassian;

import java.util.*;

public class MostPopularImpl implements MostPopular {

    Map<Integer, Long> contentToValue;
    HashMap<Long, Set<Integer>> valueToContentId;
    long maxValue;

    public MostPopularImpl() {
        this.contentToValue = new HashMap<>();
        this.valueToContentId = new HashMap<>();
        this.maxValue = Long.MIN_VALUE;
    }

    @Override
    public void increasePopularity(Integer contentId) {
        long oldValue = contentToValue.getOrDefault(contentId, 0L);
        long newValue = oldValue +1;
        maxValue = Long.max(newValue, maxValue);
        change(contentId, newValue, oldValue);
    }

    @Override
    public Integer mostPopular() {
        return valueToContentId.getOrDefault(maxValue, new HashSet<>()).stream().findFirst().orElse(0);
    }

    @Override
    public void decreasePopularity(Integer contentId) {
        long oldValue = contentToValue.getOrDefault(contentId, 0L);
        if(maxValue == oldValue && isLastValueByKey(oldValue)){
                maxValue = maxValue -1;
        }
        change(contentId, oldValue - 1, oldValue);
    }

    private void change(int contentId, long newValue, long oldValue){
        addNewValue(contentId, newValue);
        removeOldValue(contentId, oldValue);
        contentToValue.put(contentId, newValue);
    }

    private void removeOldValue(int contentId, long contentValue) {
        if(!valueToContentId.containsKey(contentValue)) return;
        Set<Integer> contentIdSet = valueToContentId.get(contentValue);
        if(contentIdSet.isEmpty()) valueToContentId.remove(contentValue);
        else contentIdSet.remove(contentId);
    }

    private void addNewValue(int contentId, long newValue) {
        Set<Integer> newContentIdSet = valueToContentId.getOrDefault(newValue, new HashSet<>());
        newContentIdSet.add(contentId);
        valueToContentId.put(newValue, newContentIdSet);
    }
    private boolean isLastValueByKey(Long oldValue){
        Set<Integer> contentIdSet = valueToContentId.get(oldValue);
        return contentIdSet != null && contentIdSet.size() == 1;
    }
}
