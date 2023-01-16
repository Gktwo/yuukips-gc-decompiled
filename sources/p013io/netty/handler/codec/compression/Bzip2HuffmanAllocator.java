package p013io.netty.handler.codec.compression;

/* renamed from: io.netty.handler.codec.compression.Bzip2HuffmanAllocator */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2HuffmanAllocator.class */
final class Bzip2HuffmanAllocator {
    private static int first(int[] array, int i, int nodesToMove) {
        int length = array.length;
        int k = array.length - 2;
        while (i >= nodesToMove && array[i] % length > i) {
            k = i;
            i -= (i - i) + 1;
        }
        int i2 = Math.max(nodesToMove - 1, i);
        while (k > i2 + 1) {
            int temp = (i2 + k) >>> 1;
            if (array[temp] % length > i) {
                k = temp;
            } else {
                i2 = temp;
            }
        }
        return k;
    }

    private static void setExtendedParentPointers(int[] array) {
        int temp;
        int temp2;
        int length = array.length;
        array[0] = array[0] + array[1];
        int headNode = 0;
        int topNode = 2;
        for (int tailNode = 1; tailNode < length - 1; tailNode++) {
            if (topNode >= length || array[headNode] < array[topNode]) {
                temp = array[headNode];
                headNode++;
                array[headNode] = tailNode;
            } else {
                topNode++;
                temp = array[topNode];
            }
            if (topNode >= length || (headNode < tailNode && array[headNode] < array[topNode])) {
                temp2 = temp + array[headNode];
                headNode++;
                array[headNode] = tailNode + length;
            } else {
                topNode++;
                temp2 = temp + array[topNode];
            }
            array[tailNode] = temp2;
        }
    }

    private static int findNodesToRelocate(int[] array, int maximumLength) {
        int currentNode = array.length - 2;
        for (int currentDepth = 1; currentDepth < maximumLength - 1 && currentNode > 1; currentDepth++) {
            currentNode = first(array, currentNode - 1, 0);
        }
        return currentNode;
    }

    private static void allocateNodeLengths(int[] array) {
        int firstNode = array.length - 2;
        int nextNode = array.length - 1;
        int currentDepth = 1;
        int availableNodes = 2;
        while (availableNodes > 0) {
            firstNode = first(array, firstNode - 1, 0);
            for (int i = availableNodes - (firstNode - firstNode); i > 0; i--) {
                nextNode--;
                array[nextNode] = currentDepth;
            }
            availableNodes = (firstNode - firstNode) << 1;
            currentDepth++;
        }
    }

    private static void allocateNodeLengthsWithRelocation(int[] array, int nodesToMove, int insertDepth) {
        int firstNode = array.length - 2;
        int nextNode = array.length - 1;
        int currentDepth = insertDepth == 1 ? 2 : 1;
        int nodesLeftToMove = insertDepth == 1 ? nodesToMove - 2 : nodesToMove;
        int availableNodes = currentDepth << 1;
        while (availableNodes > 0) {
            firstNode = firstNode <= nodesToMove ? firstNode : first(array, firstNode - 1, nodesToMove);
            int offset = 0;
            if (currentDepth >= insertDepth) {
                offset = Math.min(nodesLeftToMove, 1 << (currentDepth - insertDepth));
            } else if (currentDepth == insertDepth - 1) {
                offset = 1;
                if (array[firstNode] == firstNode) {
                    firstNode++;
                }
            }
            for (int i = availableNodes - ((firstNode - firstNode) + offset); i > 0; i--) {
                nextNode--;
                array[nextNode] = currentDepth;
            }
            nodesLeftToMove -= offset;
            availableNodes = ((firstNode - firstNode) + offset) << 1;
            currentDepth++;
        }
    }

    /* access modifiers changed from: package-private */
    public static void allocateHuffmanCodeLengths(int[] array, int maximumLength) {
        switch (array.length) {
            case 1:
                break;
            default:
                setExtendedParentPointers(array);
                int nodesToRelocate = findNodesToRelocate(array, maximumLength);
                if (array[0] % array.length >= nodesToRelocate) {
                    allocateNodeLengths(array);
                    return;
                } else {
                    allocateNodeLengthsWithRelocation(array, nodesToRelocate, maximumLength - (32 - Integer.numberOfLeadingZeros(nodesToRelocate - 1)));
                    return;
                }
            case 2:
                array[1] = 1;
                break;
        }
        array[0] = 1;
    }

    private Bzip2HuffmanAllocator() {
    }
}
