package icu.zheteng;

import jdk.incubator.foreign.MemoryHandles;
import jdk.incubator.foreign.MemorySegment;

import java.nio.ByteOrder;

/**
 * @author yancy
 */

public class MemoryAccessDemo {

    public static void main(String[] args) {
        // 获取内存访问var句柄
        var handle = MemoryHandles.varHandle(char.class, ByteOrder.nativeOrder());
        // 申请200字节的堆外内存
        try (MemorySegment segment = MemorySegment.allocateNative(200L)) {
            for (int i = 0; i < 25; i++) {
                handle.set(segment, i << 2, (char) (i + 1 + 64));
                System.out.println(handle.get(segment, i << 2));
            }
        }
    }
}

