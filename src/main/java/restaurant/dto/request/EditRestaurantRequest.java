package restaurant.dto.request;

import jakarta.validation.constraints.NotNull;
import restaurant.model.enums.RestType;
import restaurant.validation.experience.ExperienceValidation;

public record EditRestaurantRequest(
        String name,
        String location,
        RestType restType,
        @ExperienceValidation
        @NotNull
        Integer service
) {
}
