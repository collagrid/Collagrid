package io.github.collagid.core.api.io;

import io.github.collagid.core.api.dtos.*;
import io.github.collagid.core.api.field.FieldDTO;
import io.github.collagid.core.api.utils.IdUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RandomDataLoaderTest {

    private RandomDataLoader dataLoader;
    private String dstId;
    private List<String> orders;

    @BeforeEach
    void setUp() {
        dataLoader = new RandomDataLoader();
        dstId = IdUtils.getDstId();
        orders = new ArrayList<>();
    }

    @Test
    void testLoadSnapshot() {
        SnapshotDTO snapshot = dataLoader.loadSnapshot(dstId);

        // Check the number of views
        assertEquals(1, snapshot.getViews().size());

        // Check the number of fields
        assertEquals(3, snapshot.getFieldMap().size());

        // Check each field
        for (int i = 0; i < 3; i++) {
            String fid = snapshot.getViews().get(0).getColumns().get(i).getColumnId();
            FieldDTO field = snapshot.getFieldMap().get(fid);
            assertEquals("field " + i, field.getName());
            assertEquals(1, field.getType());
        }

        // Check records in views and chunks
        for (ViewDTO view : snapshot.getViews()) {
            for (ChunkDTO chunk : view.getChunks()) {
                assertEquals(100, chunk.getRows().size());
                for (RecordDTO record : chunk.getRecords()) {
                    assertNotNull(record.getId());
                    assertEquals(0, record.getV());
                    assertEquals(Collections.singletonList(0), record.getRh());
                    for (ColumnDTO field : view.getColumns()) {
                        assertNotNull(record.getFieldData(field.getColumnId()));
                    }
                }
            }
        }
    }

}