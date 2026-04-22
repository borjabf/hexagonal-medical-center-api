package com.borja.hexagonal.application.services;

import com.borja.hexagonal.domain.model.Center;
import com.borja.hexagonal.domain.ports.out.CenterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CenterServiceTest {

    @Mock
    private CenterRepository centerRepository;

    @InjectMocks
    private CenterService centerService;

    @Test
    void should_create_center_successfully() {
        // Arrange
        Center input = new Center(null, "Centro Salud", "Calle A", List.of("Urgencias"));
        Center saved = new Center("1", "Centro Salud", "Calle A", List.of("Urgencias"));
        Mockito.when(centerRepository.save(any(Center.class))).thenReturn(saved);

        // Act
        Center result = centerService.execute(input);

        // Assert
        assertNotNull(result.getId());
        assertEquals("Centro Salud", result.getName());
        Mockito.verify(centerRepository, Mockito.times(1)).save(input);
    }

    @Test
    void should_find_center_by_id() {
        // Arrange
        String id = "1";
        Center expectedCenter = new Center(id, "Centro Salud", "Calle A", List.of("Urgencias"));
        Mockito.when(centerRepository.findById(id)).thenReturn(Optional.of(expectedCenter));

        // Act
        Optional<Center> result = centerService.findById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Centro Salud", result.get().getName());
        Mockito.verify(centerRepository).findById(id);
    }

    @Test
    void should_return_all_centers() {
        // Arrange
        List<Center> mockList = List.of(
                new Center("1", "Centro A", "Calle A", List.of("X")),
                new Center("2", "Centro B", "Calle B", List.of("Y"))
        );
        Mockito.when(centerRepository.findAll()).thenReturn(mockList);

        // Act
        List<Center> result = centerService.findAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Centro A", result.get(0).getName());
        Mockito.verify(centerRepository).findAll();
    }

    @Test
    void should_delete_center_by_id() {
        // Arrange
        String id = "1";
        // No necesitamos 'when' porque el método del repo es void

        // Act
        centerService.execute(id);

        // Assert
        // Verificamos que el servicio le dio la orden al repositorio
        Mockito.verify(centerRepository, Mockito.times(1)).deleteById(id);
    }
}