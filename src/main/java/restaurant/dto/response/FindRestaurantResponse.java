package restaurant.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import restaurant.model.enums.RestType;

import java.util.List;

@Builder
public record FindRestaurantResponse(
        Long id,
        String name,
        String location,
        @Enumerated(EnumType.STRING)
        RestType restType,
        int numberOfEmployees,
        String service,
        UserAminResponse userAminResponse,
        List<MenuItemsResponse> menuItems

) {
}
