<script setup lang="ts">
import axios from "axios";
import {ref} from "vue";
import {useRouter} from "vue-router";

const items = ref([]);
const itemType = ref([]);
const search = ref([])
const typeName = ref("");
const count = ref(true);
const route = new useRouter();

const shortage = () => {
  route.push({
    path: "/shortageSearch",
  });
};

const itemCreate = function (typeName) {
  axios.get("/api/items/search?", {
    params: {typeName: typeName}
  })
      .then(response => {
        response.data.data.forEach((r: any) => {
          search.value.push(r)
        });
      });
};

axios.get("/api/items/type").then(response => {
  response.data.data.forEach((r: any) => {
    itemType.value.push(r)
  });
});

axios.get("/api/items").then(response => {
  response.data.data.forEach((r: any) => {
    items.value.push(r)
  });
});

</script>

<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="16">

          <el-table v-if="count === false" :data="search">
            <el-table-column prop="itemCode" label="상품코드"/>
            <el-table-column prop="typeCode" label="분류코드"/>
            <el-table-column prop="typeName" label="분류이름"/>
            <el-table-column prop="name" label="상품이름"/>
            <el-table-column prop="price" label="상품가격"/>
            <el-table-column prop="quantity" label="재고수량"/>
          </el-table>

        <el-table v-else-if="count === true" :data="items">
          <el-table-column prop="itemCode" label="상품코드"/>
          <el-table-column prop="typeCode" label="분류코드"/>
          <el-table-column prop="typeName" label="분류이름"/>
          <el-table-column prop="name" label="상품이름"/>
          <el-table-column prop="price" label="상품가격"/>
          <el-table-column prop="quantity" label="재고수량"/>
        </el-table>

      </el-col>
      <el-col :span="8">
        <el-button type="primary" @click=shortage()>
          부족 물품 검색
        </el-button>
        <el-button type="primary" @click="count=true">
          전체 물품 검색
        </el-button>
        <el-row :gutter="20">
          <el-col :span="16">
            <el-form label-width="100px"
                     el-input-width="100px"
            >
              <el-form-item label="제품 분류">
                <el-select v-model="typeName">
                  <el-option v-for="(type, index) in itemType" :key="index" :value="type.name">
                    {{ type.name }}
                  </el-option>
                </el-select>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="8">
            <el-form-item>
              <el-button type="primary" @click="itemCreate(typeName), count=false;">
                검색
              </el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<style>
</style>