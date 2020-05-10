package co.s4n.corrientazos.app.executor;

import co.s4n.corrientazos.domain.usecase.UseCase;
import co.s4n.corrientazos.domain.usecase.UseCaseExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class UseCaseExecutorImpl implements UseCaseExecutor {

    private Executor executor;

    public UseCaseExecutorImpl(Executor executor) {
        this.executor = executor;
    }

    @Override
    public <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<RX> execute(
            UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {
        return CompletableFuture
                .supplyAsync(() -> input, executor)
                .thenApplyAsync(useCase::execute, executor)
                .thenApplyAsync(outputMapper, executor);
    }
}
