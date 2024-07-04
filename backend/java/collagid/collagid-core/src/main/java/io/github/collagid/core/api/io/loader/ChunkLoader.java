package io.github.collagid.core.api.io.loader;

import io.github.collagid.core.api.dtos.ChunkDTO;

public interface ChunkLoader {

    ChunkDTO loadChunk(String dstId, String viewId, String chunkId);
}
