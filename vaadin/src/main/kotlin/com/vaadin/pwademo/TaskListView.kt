package com.vaadin.pwademo

import com.github.vok.karibudsl.flow.*
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.checkbox.Checkbox
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.renderer.ComponentRenderer
import com.vaadin.flow.router.Route

@Route("", layout = MainLayout::class)
class TaskListView : VerticalLayout() {
    private lateinit var form: AddTaskForm
    private lateinit var grid: Grid<Task>

}
