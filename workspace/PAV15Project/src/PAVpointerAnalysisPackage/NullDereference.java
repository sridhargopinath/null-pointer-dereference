package PAVpointerAnalysisPackage;

import java.io.*;
import java.util.*;

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IField;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.core.tests.callGraph.CallGraphTestUtil;
import com.ibm.wala.ipa.callgraph.AnalysisCache;
import com.ibm.wala.ipa.callgraph.AnalysisOptions;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.callgraph.CGNode;
import com.ibm.wala.ipa.callgraph.CallGraph;
import com.ibm.wala.ipa.callgraph.CallGraphBuilder;
import com.ibm.wala.ipa.callgraph.Entrypoint;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ssa.IR;
import com.ibm.wala.ssa.SSACFG;
import com.ibm.wala.ssa.SSAGetInstruction;
import com.ibm.wala.ssa.SSAInstruction;
import com.ibm.wala.ssa.SSAPutInstruction;
import com.ibm.wala.types.FieldReference;
import com.ibm.wala.util.CancelException;
import com.ibm.wala.util.config.AnalysisScopeReader;
import com.ibm.wala.util.io.FileProvider;
import com.ibm.wala.ssa.analysis.ExplodedControlFlowGraph;

public class NullDereference {

	void entry() {
		System.out.println("this is a successful test");
		Data d = new Data();
		d.add("1", "test");
		d.add("1", "test2");
		d.add("1", "test3");
		d.add("2", "test4");
		d.add("2", "test5");

		// d.remove("2");
		d.get("1");
		d.get("2");
		d.join("3", "1", "2");
		d.get("3");

		d.mark("3");
		d.unmark("3");
		if (d.marked("3"))
			d.get("3");
		d.remove("3", "test2");
		d.get("3");

		d.add("3", "null");
		d.get("3");
		d.removenull("3");
		d.get("3");

		d.add("1", "test");
		d.add("1", "test2");
		d.add("1", "test3");
		d.add("2", "test4");
		d.add("2", "test5");
		
		d.print("2");

	}

}