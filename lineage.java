public class LineageEdge extends Item<LineageEdgeVersion> {
    // the name of this LineageEdge
    private String name;
}

public class LineageEdgeVersion extends RichVersion {
    // id of the LineageEdge containing this Version
    private String lineageEdgeId;
    // id of the RichVersion that this LEV originates from
    private String fromId;
    // id of the RichVersion that this LEV points to
    private String toId;
}

public class Principal extends Node {
}

public class Workflow extends Graph {
}
