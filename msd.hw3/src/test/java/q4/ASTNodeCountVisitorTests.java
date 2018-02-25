package q4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests for ASTNodeCountVisitor
 * @author peng
 *
 */
public class ASTNodeCountVisitorTests {
	
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

		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals("sequence test1 fail", v.numCount, 2);
		assertEquals("sequence test2 fail", v.infixCount, 1);
		assertEquals("sequence test3 fail", v.decCount, 1);
		assertEquals("sequence test4 fail", v.seqCount, 1);
		assertEquals("sequence test5 fail", v.assignCount, 1);
		assertEquals("sequence test6 fail", v.varCount, 0);
		assertEquals("sequence test7 fail", v.strCount, 0);
		assertEquals("sequence test8 fail", v.prefixCount, 0);
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
	
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		assign.accept(v);
		assertEquals("assignment test1 fail", v.numCount, 2);
		assertEquals("assignment test2 fail", v.infixCount, 1);
		assertEquals("assignment test3 fail", v.assignCount, 1);
	}
	
	/**
	 * test Declaration root node
	 */
	@Test
	public void testDeclaration(){
		Variable x = new Variable("x");
		Statement decl = f.createDeclNode(x);
		assertEquals(decl.textRepresentation(), "var x;");
		
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		decl.accept(v);
		assertEquals("declaration test1 fail", v.numCount, 0);
		assertEquals("declaration test2 fail", v.infixCount, 0);
		assertEquals("declaration test3 fail", v.decCount, 1);
		assertEquals("declaration test4 fail", v.seqCount, 0);
		assertEquals("declaration test5 fail", v.assignCount, 0);
		assertEquals("declaration test6 fail", v.varCount, 0);
		assertEquals("declaration test7 fail", v.strCount, 0);
		assertEquals("declaration test8 fail", v.prefixCount, 0);

	}

	/**
	 * test InfixExpression root node
	 */
	@Test
	public void testInfix(){
		Operator plus = new Operator("+");
		Expression one = f.createNumNode(1);
		Expression two = f.createNumNode(2);
		Expression exp = f.createInfixNode(plus, one, two);
		assertEquals(exp.textRepresentation(), "1 + 2");
		
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		exp.accept(v);
		assertEquals("Infix test1 fail", v.numCount, 2);
		assertEquals("Infix test2 fail", v.infixCount, 1);
		assertEquals("Infix test3 fail", v.decCount, 0);
		assertEquals("Infix test4 fail", v.seqCount, 0);
		assertEquals("Infix test5 fail", v.assignCount, 0);
		assertEquals("Infix test6 fail", v.varCount, 0);
		assertEquals("Infix test7 fail", v.strCount, 0);
		assertEquals("Infix test8 fail", v.prefixCount, 0);

	}
	
	/**
	 * test PrefixExpression node
	 */
	@Test
	public void testPrefix(){
		Operator plus = new Operator("+");
		Expression one = f.createNumNode(1);
		Expression two = f.createNumNode(2);
		Expression exp = f.createPrefixNode(plus, one, two);
		assertEquals(exp.textRepresentation(), "+ 1 2");
		
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		exp.accept(v);
		assertEquals("prefix test1 fail", v.numCount, 2);
		assertEquals("prefix test2 fail", v.infixCount, 0);
		assertEquals("prefix test3 fail", v.decCount, 0);
		assertEquals("prefix test4 fail", v.seqCount, 0);
		assertEquals("prefix test5 fail", v.assignCount, 0);
		assertEquals("prefix test6 fail", v.varCount, 0);
		assertEquals("prefix test7 fail", v.strCount, 0);
		assertEquals("prefix test8 fail", v.prefixCount, 1);

	}
	
	/**
	 * test NumberExpression node
	 */
	@Test
	public void testNumber(){
		Expression one = f.createNumNode(1);
		Expression two = f.createNumNode(2.0);
		assertEquals(one.textRepresentation(), "1");
		assertEquals(two.textRepresentation(), "2.0");
		
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		one.accept(v);
		two.accept(v);
		assertEquals("number test1 fail", v.numCount, 2);
	}
	
	/**
	 * test StringExpression node
	 */
	@Test
	public void testString(){
		Expression s = f.createStringNode("tp");
		assertEquals(s.textRepresentation(), "tp");
		
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		s.accept(v);
		assertEquals("string test1 fail", v.strCount, 1);

	}
	
	/**
	 * test Variable node
	 */
	@Test
	public void testVariable(){
		Variable x = new Variable("x");
		Expression vs = f.createVarNode(x);
		assertEquals(vs.textRepresentation(), "x");
		
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		vs.accept(v);
		assertEquals("variable test1 fail", v.varCount, 1);
	}

}
