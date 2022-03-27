package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @Test
    public void add() {
        when(this.todoRepository.save(any(TodoEntity.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest request = new TodoRequest();
        request.setTitle("test title");
        TodoEntity actual = this.todoService.add(request);

        assertEquals(1L,  actual.getId());
        assertEquals("test title",  actual.getTitle());
    }

    @Test
    public void searchById() {
        TodoEntity todo = new TodoEntity();
        todo.setTitle("test");
        todo.setId(123L);
        todo.setOrder(0L);
        todo.setCompleted(false);
        Optional<TodoEntity> expected = Optional.of(todo);

        given(this.todoRepository.findById(anyLong()))
                .willReturn(expected);

        TodoEntity actual = this.todoService.searchById(123L);

        assertEquals(actual.getId(), 123L);
        assertEquals(actual.getOrder(), 0L);
        assertFalse(actual.getCompleted());
        assertEquals(actual.getTitle(), "test");
    }

    @Test
    public void searchByIdFailed() {
        given(this.todoRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            this.todoService.searchById(123L);
        });
    }
}
