package lab3.validators;

import org.primefaces.validate.ClientValidator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

@FacesValidator("xValidator")
public class XValidator implements Validator, ClientValidator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try {
            if (value.toString().isEmpty() || value.toString().length() > 6) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: ",
                        "Допустимая длина 6 символов"));
            }
            double xValue = (double) value;
            if (xValue < -3 || xValue > 3) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: ",
                        "Допустимые значения -3..3"));
            }
        } catch (NullPointerException | NumberFormatException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: ",
                    "Введите число"));
        }
    }

    @Override
    public Map<String, Object> getMetadata() {
        return null;
    }

    @Override
    public String getValidatorId() {
        return "xValidator";
    }
}
