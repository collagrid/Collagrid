package io.github.collagid.core.api.io;

import io.github.collagid.core.api.dtos.*;
import io.github.collagid.core.api.field.FieldDTO;
import io.github.collagid.core.api.utils.IdUtils;

import java.util.*;
import java.util.stream.Collectors;

public class RandomDataLoader extends DataLoader{
    private static final ThreadLocal<RandomLoaderOption> randomLoaderOption = ThreadLocal.withInitial(()->new RandomLoaderOptionBuilder().build());

    public static RandomLoaderOption getRandomLoaderOption() {
        return randomLoaderOption.get();
    }

    @Override
    public SnapshotDTO loadSnapshot(String dstId) {
        RandomLoaderOption option = randomLoaderOption.get();
        option.context = new SnapshotDTO();
        option.context.setDstId(dstId);
        loadFieldMap(dstId);
        for (int i = 0; i < option.viewCount; i++) {
            // load view
            String viewId = IdUtils.getViewId();
            ViewDTO viewDTO = loadView(dstId, viewId);
            option.context.addView(viewDTO);
        }
        option.context.getRecordMap().forEach((fieldId, record) -> {
            // set column
            for (FieldDTO fieldDTO : option.fieldList) {
                FieldDataDTO fieldDataDTO = new FieldDataDTO(
                        IdUtils.generateId("", 10), new DataDTO(), 0);
                record.applyFieldData(fieldDTO.getId(), fieldDataDTO);
            }
        });
        randomLoaderOption.remove();
        return option.context;
    }

    @Override
    public Map<String, FieldDTO> loadFieldMap(String dstId) {
        RandomLoaderOption option = randomLoaderOption.get();
        for (int i = 0; i < option.fieldCount; i++) {
            String fieldId = IdUtils.getFieldId();
            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setName("field " + i);
            fieldDTO.setType(1);
            fieldDTO.setId(fieldId);
            fieldDTO.setProperty(new PropertyDTO());
            option.context.addField(fieldDTO);
            option.addField(fieldDTO);
        }
        return null;
    }

    @Override
    public ViewDTO loadView(String dstId, String viewId) {
        ViewDTO viewDTO = new ViewDTO();
        viewDTO.setViewId(viewId);
        RandomLoaderOption option = randomLoaderOption.get();
        // created chunk
        for (int i = 0; i < option.chunkCount; i++) {
            ChunkDTO chunkDTO = loadChunk(dstId, viewId, viewId);
            viewDTO.addChunk(chunkDTO);
            viewDTO.setColumns(
                    option.fieldList.stream()
                            .map(f -> new ColumnDTO(f.getId(), false))
                            .collect(Collectors.toList())
            );
        }
        return viewDTO;
    }

    @Override
    public ChunkDTO loadChunk(String dstId, String viewId, String chunkId) {
        ChunkDTO chunkDTO = new ChunkDTO();
        chunkDTO.setChunkId(chunkId);
        for (RecordDTO record : loadRecords(dstId, viewId, chunkId)) {
            chunkDTO.addRecordIndex(record, true);
        }
        return chunkDTO;
    }

    @Override
    public List<RecordDTO> loadRecords(String dstId, String viewId, String chunkId) {
        RandomLoaderOption option = randomLoaderOption.get();
        List<RecordDTO> records = new ArrayList<>();
        // create record
        for (int j = 0; j < option.chunkSize; j++) {
            RecordDTO record = new RecordDTO();
            record.setId(IdUtils.getRecordId());
            record.setV(0);
            record.setRh(Collections.singletonList(0));
            record.setCa(option.now);
            record.setUa(option.now);
            records.add(record);
        }
        return records;
    }

    public RandomDataLoader withOptions(RandomLoaderOption option) {
        randomLoaderOption.set(option);
        return this;
    }



    public static class RandomLoaderOption{
        private int viewCount;
        private int chunkCount;
        private int chunkSize;
        private int fieldCount;
        public long now;
        public List<FieldDTO> fieldList;
        public SnapshotDTO context;

        private RandomLoaderOption() {
        }

        public void addField(FieldDTO fieldDTO) {
            this.fieldList.add(fieldDTO);
            this.fieldList.sort(new Comparator<FieldDTO>() {
                @Override
                public int compare(FieldDTO o1, FieldDTO o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

        public int getViewCount() {
            return viewCount;
        }

        public int getChunkCount() {
            return chunkCount;
        }

        public int getChunkSize() {
            return chunkSize;
        }

        public int getFieldCount() {
            return fieldCount;
        }

        public long getNow() {
            return now;
        }
    }

    public static class RandomLoaderOptionBuilder {
        private int viewCount;
        private int chunkCount;
        private int chunkSize;
        private int fieldCount;
        public long now;

        public RandomLoaderOptionBuilder() {
            viewCount = 1;
            chunkCount = 2;
            chunkSize = 100;
            fieldCount = 3;
            now = System.currentTimeMillis();
        }

        public RandomLoaderOption build() {
            RandomLoaderOption option = new RandomLoaderOption();
            option.viewCount = viewCount;
            option.chunkCount = chunkCount;
            option.chunkSize = chunkSize;
            option.fieldCount = fieldCount;
            option.now = now;
            option.fieldList = new ArrayList<>();
            return option;
        }

        public RandomLoaderOptionBuilder setViewCount(int viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        public RandomLoaderOptionBuilder setChunkCount(int chunkCount) {
            this.chunkCount = chunkCount;
            return this;
        }

        public RandomLoaderOptionBuilder setChunkSize(int chunkSize) {
            this.chunkSize = chunkSize;
            return this;
        }

        public RandomLoaderOptionBuilder setFieldCount(int fieldCount) {
            this.fieldCount = fieldCount;
            return this;
        }

        public RandomLoaderOptionBuilder setNow(long now) {
            this.now = now;
            return this;
        }
    }
}
