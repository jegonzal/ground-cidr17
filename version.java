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
    // the StructureVersion associated with this RichVersion
    private String structureVersionId;
    // the optional reference associated with this RichVersion
    private String reference;
    // the optional parameters if this is an external version
    private Map<String, String> parameters;
    // timestamp if this is an external version
    private Instant externalAccessTimeStamp;
    // optional cache of the external version
    private Object cachedValue;
}

public class Tag {
    private String versionId;
    // the Key of the Tag
    private String key;
    // the optional Value of the Tag
    private Object value;
    // the Type of the Value if it exists
    private GroundType valueType;
}
