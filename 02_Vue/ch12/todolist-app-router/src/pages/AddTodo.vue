<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일 : </label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <br />
      <div class="form-group">
        <label htmlFor="desc">설명 : </label>
        <input
          type="text"
          class="form-control"
          id="desc"
          v-model="todoItem.desc"
        />
      </div>
      <br />
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추 가
        </button>
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
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });

const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다.');
    return;
  }
  addTodo({ ...todoItem }, () => {
    router.push('/todos');
  }); // proxy객체가 아닌 순수 데이터 객체로 만들고 add하기 위해, spread연산자를 사용하여 내용 복사를 한다.
};
</script>
