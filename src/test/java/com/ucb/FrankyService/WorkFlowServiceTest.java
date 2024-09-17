package com.ucb.FrankyService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WorkFlowServiceTest {

//    private WorkFlowService workFlowService;

//    @BeforeEach
//    void setUp() {
//        workFlowService = new WorkFlowService();
//    }

    @InjectMocks
    WorkFlowService workFlowService;

    @Test
    @DisplayName("Lista debe estar vacía al inicio")
    void obtainList() {
        // Inicialmente la lista debe estar vacía
        assertTrue(workFlowService.obtainList().isEmpty());
    }

    @Test
    @DisplayName("Debe agregar un nuevo WorkFlow a la lista")
    void create() {
        WorkFlow workFlow = new WorkFlow("GitFlow", "descripcion1");
        workFlowService.create(workFlow);

        // Verificar que el WorkFlow se ha añadido a la lista
        assertEquals(1, workFlowService.obtainList().size());
        assertEquals(workFlow, workFlowService.obtainList().get(0));
    }

    @Test
    @DisplayName("Debe eliminar un WorkFlow de la lista")
    void delete() {
        WorkFlow workFlow = new WorkFlow("GitFlow", "descripcion1");
        workFlowService.create(workFlow);

        // Verificar que el WorkFlow se ha añadido a la lista
        assertEquals(1, workFlowService.obtainList().size());

        // Eliminar el WorkFlow
        boolean isDeleted = workFlowService.delete("GitFlow");

        // Verificar que la eliminación fue exitosa
        assertTrue(isDeleted);
        assertTrue(workFlowService.obtainList().isEmpty());

        // Intentar eliminar un WorkFlow que no existe
        boolean isDeletedAgain = workFlowService.delete("GitFlow");
        assertFalse(isDeletedAgain);
    }

    @Test
    @DisplayName("Debe actualizar la descripción de un WorkFlow")
    void update() {
        WorkFlow workFlow = new WorkFlow("GitFlow", "descripcion1");
        workFlowService.create(workFlow);

        // Verificar que el WorkFlow se ha añadido a la lista
        assertEquals(1, workFlowService.obtainList().size());

        // Actualizar la descripción del WorkFlow
        boolean isUpdated = workFlowService.update("GitFlow", "nuevaDescripcion");

        // Verificar que la actualización fue exitosa
        assertTrue(isUpdated);
        assertEquals(1, workFlowService.obtainList().size());
        assertEquals("nuevaDescripcion", workFlowService.obtainList().get(0).getDescription());

        // Intentar actualizar un WorkFlow que no existe
        boolean isUpdatedAgain = workFlowService.update("NonExistingFlow", "descripcion");
        assertFalse(isUpdatedAgain);
    }
}
