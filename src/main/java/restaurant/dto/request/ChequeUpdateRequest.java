package restaurant.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import restaurant.validation.experience.ExperienceValidation;

@Builder
public record ChequeUpdateRequest(
        @ExperienceValidation
        @NotNull
        Integer priceAvg
) {
}
