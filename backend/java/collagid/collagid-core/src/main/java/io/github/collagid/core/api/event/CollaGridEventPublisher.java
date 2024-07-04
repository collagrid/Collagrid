package io.github.collagid.core.api.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollaGridEventPublisher {
    private static final Map<CollaGridEventType, List<CollaGridEventListener<?>>> listenersMap = new HashMap<>();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static <T extends CollaGridEvent> void register(CollaGridEventListener<T> listener) {
        listenersMap.computeIfAbsent(listener.getType(), k -> new ArrayList<>()).add(listener);
    }

    public static <T extends CollaGridEvent> void publishEvent(T event) {
        if (event.getType().isAsync()) {
            return;
        }
        List<CollaGridEventListener<?>> listeners = listenersMap.get(event.getType());
        if (listeners != null) {
            for (CollaGridEventListener<?> listener : listeners) {
                notifyListener(listener, event);
            }
        }
    }

    public static <T extends CollaGridEvent> void publishEventAsync(T event) {
        if (!event.getType().isAsync()) {
            return;
        }
        CompletableFuture.runAsync(() -> {
            List<CollaGridEventListener<?>> listeners = listenersMap.get(event.getType());
            if (listeners != null) {
                for (CollaGridEventListener<?> listener : listeners) {
                    notifyListener(listener, event);
                }
            }
        }, executorService);
    }

    private static <T extends CollaGridEvent> void notifyListener(CollaGridEventListener<?> rawListener, T event) {
        @SuppressWarnings("unchecked")
        CollaGridEventListener<T> listener = (CollaGridEventListener<T>) rawListener;
        listener.handle(event);
    }
}
