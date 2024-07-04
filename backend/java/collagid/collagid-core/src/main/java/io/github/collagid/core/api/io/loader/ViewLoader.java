package io.github.collagid.core.api.io.loader;

import io.github.collagid.core.api.dtos.ViewDTO;

public interface ViewLoader {

    ViewDTO loadView(String dstId, String viewId);

}
