package compiler.a5.lexer

import compiler.a5.lexicon.A5LexiconDFA
import compiler.dfa.DFALogger
import compiler.dfa.LexicalNode
import compiler.lexer.LexerBuilder
import compiler.parser.Symbol.Terminal
import compiler.utils.TextCursor

object A5Lexer {
    fun lex(text: String): List<Terminal> {
        return LexerBuilder()
                .setDFA(A5LexiconDFA())
                .onTransition(DFALogger::logTransition)
                .onTokenCreated(DFALogger::logAcceptedToken)
                .onUnknownTokenFound(this::logUnknownToken)
                .createLexer()
                .lex(text)
    }

    fun logUnknownToken(cursor: TextCursor, state: LexicalNode.NonFinalState) {
        throw UnknownTokenException(cursor.getCurrentSentence(), cursor)
    }
}