# arnoldc-interpreter
Java implementation of an Interpreter for [this programming language (called ArnoldC)](https://github.com/lhartikk/ArnoldC) based on the one-liners of Arnold Schwarzenegger.

The project has a Class AbstractSyntaxTree in which the AST is kept. The AST has a MainNode at which all the other nodes are connected.

The ArnoldCFileParser static methods are used in order to parse the “.ac” files and get the Arnold expressions that build the AST. After the parser finds the expressions, a NodeFactory is used in order to create all the nodes that are going to be in the tree (Factory Design Pattern), depending on the ArnoldC expression found. After each new node is created, the current node is changed accordingly (Visitor Design Pattern).
