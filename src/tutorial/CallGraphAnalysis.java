package tutorial;

import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.*;

import java.util.*;

public class CallGraphAnalysis extends SceneTransformer {
    private final List<SootMethod> _entryPoints;

    public CallGraphAnalysis(List<SootMethod> entryPoints) {
        _entryPoints = entryPoints;
    }

    @Override
    protected void internalTransform(String phaseName, Map<String, String> options) {
        CallGraph cg = Scene.v().getCallGraph();
        printPartialCallGraph(cg);
    }

    private void printPartialCallGraph(CallGraph cg) {
        // Print only the entry-points and the methods they invoke.
        for (SootMethod entryPoint : _entryPoints) {
            System.out.println("Entry-point: " + entryPoint);

            Iterator<Edge> outEdges = cg.edgesOutOf(entryPoint);

            while (outEdges.hasNext()) {
                Edge outEdge = outEdges.next();
                SootMethod invokedMethod = outEdge.getTgt().method();
                System.out.println("  invokes " + invokedMethod);
            }
        }
    }
}
