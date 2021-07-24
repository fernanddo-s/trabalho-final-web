<template>
  <CCardBody>
    <CDataTable
      :items="items"
      sorter
      column-filter
      table-filter
      items-per-page-select
      :items-per-page="5"
      hover
      pagination
    >
      <template #registeredTimestamp="{item}">
        <td>
          {{ item.registeredDate }}
        </td>
      </template>
    </CDataTable>
  </CCardBody>
</template>

<script>
import HTTP from "@/views/services/HTTP";

const fields = [
  "username",
  { key: "registeredTimestamp", label: "Registered" },
  "role",
  "status",
];

export default {
  name: "itemsComputationTable",
  data() {
    return {
      fields,
      startDate: 1325376000000,
      endDate: 1330560000000,
      items: [],
    };
  },
  computed: {
    computedItems() {
      return items.map((item) => {
        return {
          ...item,
          registeredTimestamp: item.registered.timestamp,
          registeredDate: item.registered.date,
        };
      });
    },
    dateFilteredItems() {
      return this.computedItems.filter((item) => {
        const date = item.registeredTimestamp;
        return item.author >= this.startDate && date <= this.endDate;
      });
    },
  },

  created() {
    this.sendRequest();
  },

  methods: {
    setDateFilter(e, end) {
      if (end) {
        this.endDate = new Date(e.target.value).getTime();
      } else {
        this.startDate = new Date(e.target.value).getTime();
      }
    },

    sendRequest() {
      HTTP.listaDeLivro()
        .then((items) => {
          this.items = items.data;
          console.log(this.items);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>
