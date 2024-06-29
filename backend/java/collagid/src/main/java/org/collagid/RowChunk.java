package org.collagid;

import java.util.*;

public class RowChunk {
    private List<String> chunks = new ArrayList<>();
    private Map<String, List<String>> chunkMap = new HashMap<>();
    private int totalCount = 0;

    public void print() {
        for (String chunk : chunks) {
            System.out.println(chunk + ":");
            List<String> strings = chunkMap.get(chunk);
            for (String string : strings) {
                System.out.println(" " + string);
            }
        }
    }

    public void addRow(String rowId, int index) {
        if (index > totalCount) {
            index = totalCount;
        }
        Map.Entry<String, Integer> chunkKeyByOrder = getChunkKeyByOrder(index);
        String chunkKey = chunkKeyByOrder.getKey();
        int o = chunkKeyByOrder.getValue();
        List<String> strings = chunkMap.get(chunkKey);
        strings.add(o, rowId);
        if (strings.size() >= 120) {
            List<String> right = new ArrayList<>(strings.subList(60, strings.size()));
            strings.subList(60, strings.size()).clear(); // Clear the sublist in-place
            String random = random();
            chunkMap.put(random, right);
            chunks.add(chunks.indexOf(chunkKey) + 1, random);
        }
        totalCount += 1;
    }

    public Map.Entry<String, Integer> getChunkKeyByOrder(int index) {
        if (chunks.isEmpty()) {
            String random = random();
            chunks.add(random);
            chunkMap.put(random, new ArrayList<>());
            return new AbstractMap.SimpleEntry<>(random, 0);
        }
        int size = 0;
        for (String chunk : chunks) {
            List<String> strings = chunkMap.get(chunk);
            size += strings.size();
            if (index <= size) {
                return new AbstractMap.SimpleEntry<>(chunk, index - (size - strings.size()));
            }
        }
        return new AbstractMap.SimpleEntry<>(chunks.get(chunks.size() - 1), index - size);
    }

    private String random() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}