public class Item<T extends Version> {
    private String id;
}

public class NodeVersion extends RichVersion {
    // the id of the Node containing this Version
    private String nodeId;
}

public class EdgeVersion extends RichVersion {
    // the id of the Edge containing this Version
    private String edgeId;
    // the id of the NodeVersion that this EV originates from
    private String fromId;
    // the id of the NodeVersion that this EV points to
    private String toId;
}

public class GraphVersion extends RichVersion {
    // the id of the Graph that contains this Version
    private String graphId;
    // the list of ids of EdgeVersions in this GraphVersion
    private List<String> edgeVersionIds;
}

public class Node extends Item<NodeVersion> {
    // the name of this Node
    private String name;
}

public class Edge extends Item<EdgeVersion> {
    // the name of this Edge
    private String name;
}

public class Graph extends Item<GraphVersion> {
    // the name of this Graph
    private String name;
}

public class StructureVersion extends Version {
    // the id of the Structure containing this Version
    private String structureId;
    // the map of attribute names to types
    private Map<String, GroundType> attributes;
}

public class Structure extends Item<StructureVersion> {
    // the name of this Structure
    private String name;
}
