<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
import axios from 'axios';

const BASEURI = '/api/todos';

// const states = reactive({
//   todoList: [
//     { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
//     { id: 2, todo: 'React학습', desc: '설명2', done: false },
//     { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
//     { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
//   ],
// });
const states = reactive({
  todoList: [],
});
const fetchTodoList = async () => {
  // TodoList 목록 전체 조회
  try {
    const resp = await axios.get(BASEURI);
    if (resp.status === 200) {
      states.todoList = resp.data;
    } else {
      console.log('데이터 조회 실패');
    }
  } catch (error) {
    alert('에러발생 : ' + error);
  }
};

// const addTodo = ({ todo, desc } => {
//   states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
// }; // todo : todo 인 경우 todo로 생략 가능

const addTodo = async ({ todo, desc }, successCallback) => {
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false }); // done은 false값으로 덮어쓰기
      successCallback(); // 성공 후, 어디로 이동할 것인지 정하는 콜백함수를 추후에 인자로 넘겨줄 것.
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 : ' + error);
  }
};

// const updateTodo = ({ id, todo, desc, done }) => {
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   states.todoList[index] = { ...states.todoList[index], todo, desc, done };
// };
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  try {
    const payload = { todo, desc };
    const resp = await axios.put(BASEURI + `/${id}`, payload);
    if (resp.status == 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    }
  } catch (e) {
    alert('Todo 변경 실패');
  }
};

const deleteTodo = async (id) => {
  try {
    const response = await axios.delete(BASEURI + `/${id}`);
    console.log(response.status, response.data);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (error) {
    alert('에러 발생: ' + error);
  }
};

const toggleDone = async (id) => {
  try {
    let todo = states.todoList.find((todo) => todo.id === id);
    // todo 값을 그대로 복사한 후, done값만 변경
    let payload = { ...todo, done: !todo.done };
    const response = axios.put(BASEURI + `/${id}`, payload);
    if (response.status == 200) {
      todo.done = payload.done;
    } else {
      alert('Todo 완료상태 변경 실패');
    }
  } catch (error) {
    alert('에러발생: ' + error);
  }
};

provide(
  'todoList',
  computed(() => states.todoList)
);

provide('actions', {
  fetchTodoList,
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
});

fetchTodoList(); // 초기 리스트 세팅 (setup에서 이 함수를 실행하지 않으면, 새로고침 전에는 리스트가 보이지 않음. ㅜ)
</script>
