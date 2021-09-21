package clean.architecture.core.usecase;

public abstract class BaseUseCase<I extends BaseUseCase.InputValues, O extends BaseUseCase.OutputValues> {
    public abstract O execute(I input);

    public interface InputValues {
    }

    public interface OutputValues {
    }
}