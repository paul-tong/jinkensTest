package q4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests for search visitor
 * @author peng
 *
 */
public class ASTSearchVisitorTests {
	
	public NodeFactory f = new NodeFactory();
	
	/**
	 * root node is sequence
	 */
	@Test
	public void testSequence(){
		Variable x = new Variable("x");
		Operator plus = new Operator("+");
		Expression one = f.createNumNode(1);
		Expression two = f.createNumNode(2);
		Expression exp = f.createInfixNode(plus, one, two);
		Statement decl = f.createDeclNode(x);
		Statement assign = f.createAssignNode(x,exp);
		Statement seq = f.createSequenceNode(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");

		ASTSearchVisitor v = new ASTSearchVisitor("x"); // contains given variable name
		seq.accept(v);
		Iterator<Node> it = v.nodes.iterator();
		assertEquals("sequence test1 fail", it.nextElement(), decl);
		assertEquals("sequence test2 fail", it.nextElement(), assign);
		assertEquals("sequence test3 fail", it.hasAnotherElement(), false);
		assertEquals("sequence test4 fail", v.nodes.size(), 2);
		
		ASTSearchVisitor v2 = new ASTSearchVisitor("y"); // does not contain given variable name
		seq.accept(v2);
		Iterator<Node> it2 = v2.nodes.iterator();
		assertEquals("sequence test5 fail", it2.hasAnotherElement(), false);
		assertEquals("sequence test6 fail", v2.nodes.size(), 0);
		
	}
	
	/**
	 * test Assignment root node
	 */
	@Test
	public void testAssignment(){
		Variable x = new Variable("x");
		Operator plus = new Operator("+");
		Expression one = f.createNumNode(1);
		Expression two = f.createNumNode(2);
		Expression exp = f.createInfixNode(plus, one, two);
		Statement assign = f.createAssignNode(x,exp);
		assertEquals(assign.textRepresentation(), "x = 1 + 2;");
	
		ASTSearchVisitor v = new ASTSearchVisitor("x"); // contains given variable name
		assign.accept(v);
		Iterator<Node> it = v.nodes.iterator();
		assertEquals("Assignment test1 fail", it.nextElement(), assign);
		assertEquals("Assignment test2 fail", v.nodes.size(), 1);
		
		ASTSearchVisitor v2 = new ASTSearchVisitor("y"); // does not contain given variable name
		assign.accept(v2);
		Iterator<Node> it2 = v2.nodes.iterator();
		assertEquals("sequence test3 fail", it2.hasAnotherElement(), false);
		assertEquals("sequence test4 fail", v2.nodes.size(), 0);
	}
	
	/**
	 * test Declaration root node
	 */
	@Test
	public void testDeclaration(){
		Variable x = new Variable("x");
		Statement decl = f.createDeclNode(x);
		assertEquals(decl.textRepresentation(), "var x;");
		
		ASTSearchVisitor v = new ASTSearchVisitor("x"); // contains given variable name
		decl.accept(v);
		Iterator<Node> it = v.nodes.iterator();
		assertEquals("Declaration test1 fail", it.nextElement(), decl);
		assertEquals("Declaration test2 fail", v.nodes.size(), 1);
		
		ASTSearchVisitor v2 = new ASTSearchVisitor("y"); // does not contain given variable name
		decl.accept(v2);
		Iterator<Node> it2 = v2.nodes.iterator();
		assertEquals("Declaration test3 fail", it2.hasAnotherElement(), false);
		assertEquals("Declaration test4 fail", v2.nodes.size(), 0);
	}


}
