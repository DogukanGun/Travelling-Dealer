package kotlinversion

data class Graph<T>(
    val vertices: Set<T>,
    val edges: Map<T, Set<T>>,
    val weights: Map<Pair<T, T>, Int>
)