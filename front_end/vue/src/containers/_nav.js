export default [
  {
    _name: "CSidebarNav",
    _children: [
      {
        _name: "CSidebarNavTitle",
        _children: ["crud"],
      },
      {
        _name: "CSidebarNavItem",
        name: "Incluir",
        to: "/crud/incluir",
        icon: "cil-puzzle",
      },
      {
        _name: "CSidebarNavItem",
        name: "Remover",
        to: "/crud/Remover",
        icon: "cil-puzzle",
      },
      {
        _name: "CSidebarNavItem",
        name: "Editar",
        to: "/crud/editar",
        icon: "cil-puzzle",
      },
      {
        _name: "CSidebarNavItem",
        name: "Listar",
        to: "/crud/listar",
        icon: "cil-puzzle",
      },
    ],
  },
];
