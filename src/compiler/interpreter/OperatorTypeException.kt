package compiler.interpreter

import compiler.parser.Symbols.Terminal
import compiler.parser.Symbols.Terminal.Operator
import compiler.parser.UserException

class OperatorTypeException(op: Operator, left: Terminal, right: Terminal) :
        UserException("Operator '${op.str}' is not defined between types ${left.str} and ${right.str}", right)
