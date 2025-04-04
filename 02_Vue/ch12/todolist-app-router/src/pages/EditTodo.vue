<template>
  <div class="row">
    <div class="col p-3"><h2>할일 수정</h2></div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label> 할일 : </label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label> 설명 : </label>
        <input
          type="text"
          class="form-control"
          id="desc"
          v-model="todoItem.desc"
        />
      </div>
      <div class="form group">
        <label htmlFor="done">완료여부 : </label>
        <input type="checkbox" v-model="todoItem.done" />
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="updateTodoHandler"
        >
          수 정
        </button>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취 소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, inject } from 'vue';
import { useRouter, useRoute } from 'vue-router';

const todoList = inject('todoList');
const { updateTodo } = inject('actions');
const router = useRouter();
const currentRoute = useRoute();

const matchedTodoItem = todoList.value.find(
  (item) => item.id === parseInt(currentRoute.params.id)
);

if (!matchedTodoItem) {
  router.push('/todos');
}

/* todoItem은 원본의 복사본.
수정 중에 취소하는 경우를 대비하여, 원본 데이터를 바로 수정하지 않고 복사하여 수정한 뒤 updateTodo로 변경하도록 한다. */
const todoItem = reactive({ ...matchedTodoItem });
const updateTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다.');
    return;
  }
  updateTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};
</script>
