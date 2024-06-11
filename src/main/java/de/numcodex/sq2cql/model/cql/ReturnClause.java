package de.numcodex.sq2cql.model.cql;

import de.numcodex.sq2cql.PrintContext;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public record ReturnClause(Expression<?> expression) implements Clause {

    public ReturnClause {
        requireNonNull(expression);
    }

    public static ReturnClause of(Expression<?> expression) {
        return new ReturnClause(expression);
    }

    @Override
    public String print(PrintContext printContext) {
        assert printContext.precedence() == 0;
        return "return " + expression.print(printContext.resetPrecedence().increase());
    }

    @Override
    public ReturnClause withIncrementedSuffixes(Map<String, Integer> increments) {
        return new ReturnClause(expression.withIncrementedSuffixes(increments));
    }
}
