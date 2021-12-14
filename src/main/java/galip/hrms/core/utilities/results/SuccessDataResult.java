package galip.hrms.core.utilities.results;

public class SuccessDataResult extends DataResult{
    public SuccessDataResult(Object data) {
        super(true, data);
    }

    public SuccessDataResult(String message, Object data) {
        super(true, message, data);
    }

}
