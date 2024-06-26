package restaurant.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import restaurant.model.enums.RestType;

public record AllRestResponse(
        Long id,
        String name,
        String location,
        @Enumerated(EnumType.STRING)
        RestType restType,
        int numberOfEmployees,
        int service
) {
}
