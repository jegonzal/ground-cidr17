// VERSION GRAPHS
public class Item<T extends Version> {
    private String id;
}


public class Version {
    private String id;
}

public class VersionSuccessor<T extends Version> {
    // the unique id of this VersionSuccessor
    private String id;

    // the id of the Version that originates this successor
    private String fromId;

    // the id of the Version that this success points to
    private String toId;
}


public class VersionHistoryDAG<T extends Version> {
    // the id of the Version that's at the rootId of this DAG
    private String itemId;

    // list of VersionSuccessors that make up this DAG
    private List<String> edgeIds;

    // map of parents to children
    private Map<String, List<String>> parentChildMap;
}


public class RichVersion extends Version {
    // the map of Keys to Tags associated with this RichVersion
    private Map<String, Tag> tags;

    @UnwrapValidatedValue
    // the StructureVersion associated with this RichVersion
    private String structureVersionId;

    @UnwrapValidatedValue
    // the optional reference associated with this RichVersion
    private String reference;

    @UnwrapValidatedValue
    // the optional parameters associated with this RichVersion if there is a reference
    private Map<String, String> parameters;
}

public class NodeVersion extends RichVersion {
    private static final Logger LOGGER = LoggerFactory.getLogger(NodeVersion.class);

    // the id of the Node containing this Version
    private String nodeId;
}

public class EdgeVersion extends RichVersion {
    // the id of the Edge containing this Version
    private String edgeId;

    // the id of the NodeVersion that this EdgeVersion originates from
    private String fromId;

    // the id of the NodeVersion that this EdgeVersion points to
    private String toId;
}

public class StructureVersion extends Version {
    // the id of the Structure containing this Version
    private String structureId;

    // the map of attribute names to types
    private Map<String, GroundType> attributes;
}

public class GraphVersion extends RichVersion {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphVersion.class);

    // the id of the Graph that contains this Version
    private String graphId;

    // the list of ids of EdgeVersions in this GraphVersion
    private List<String> edgeVersionIds;
}

// MODEL GRAPHS
public class Node extends Item<NodeVersion> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Node.class);

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

public class Structure extends Item<StructureVersion> {
    // the name of this Structure
    private String name;
}

public class Tag {
    private String versionId;

    @NotEmpty
    // the Key of the Tag
    private String key;

    @UnwrapValidatedValue
    // the optional Value of the Tag
    private Object value;

    @UnwrapValidatedValue
    // the Type of the Value if it exists
    private GroundType valueType;
}

// USAGE GRAPHS
public class LineageEdge extends Item<LineageEdgeVersion> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LineageEdge.class);

    // the name of this LineageEdge
    private String name;
}

public class LineageEdgeVersion extends RichVersion {
    private static final Logger LOGGER = LoggerFactory.getLogger(LineageEdgeVersion.class);

    // the id of the LineageEdge containing this Version
    private String lineageEdgeId;

    // the id of the RichVersion that this LineageEdgeVersion originates from
    private String fromId;

    // the id of the RichVersion that this LineageEdgeVersion points to
    private String toId;
}
