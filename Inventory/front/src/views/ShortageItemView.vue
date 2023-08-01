<script setup lang="ts">
import {defineProps, onMounted, ref} from "vue";
import axios from "axios";

const props = defineProps({
  typeName: {
    type: String,
    require: true,
  },
  quantity: {
    type: [Number, String],
    require: true,
  }
});
const post = ref([]);

onMounted(() => {
  axios.get(`/api/items/shortage?typeName=${props.typeName}&quantity=${props.quantity}` ).then(response => {
    response.data.data.forEach((r: any) => {
      post.value.push(r)
    });
  });
});

</script>

<template>
  <div>
    <el-table :data="post">
      <el-table-column prop="itemCode" label="상품코드"/>
      <el-table-column prop="typeCode" label="분류코드"/>
      <el-table-column prop="typeName" label="분류이름"/>
      <el-table-column prop="name" label="상품이름"/>
      <el-table-column prop="price" label="상품가격"/>
      <el-table-column prop="quantity" label="재고수량"/>
    </el-table>
  </div>


</template>

