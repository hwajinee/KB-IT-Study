<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// 많이 쓰이는 경로를 변수로 선언해놓기
const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  // const url = '/api/todos/1';
  // axios.get(url).then((response) => {
  //   console.log('# 응답객체: ', response);
  // });
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      // 전체 todoList목록 출력
      todoList = response.data;
      console.log('# TodoList : ', todoList);
      return todoList[0].id;
    })
    .then((id) => {
      // 첫번째 Todo 가져오기
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      // 가져온 첫번째 Todo 출력하기 & 두번째 Todo 아디이 반환
      console.log('## 첫번째 Todo : ', response.data);
      return todoList[1].id;
    })
    .then((id) => {
      // 두번째 Todo 가져와서 출력하기
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두번째 Todo : ', response.data);
      });
    });
};

requestAPI();
</script>
