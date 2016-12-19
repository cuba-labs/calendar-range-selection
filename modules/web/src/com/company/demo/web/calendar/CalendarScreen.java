package com.company.demo.web.calendar;

import com.company.demo.entity.Task;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.components.calendar.CalendarComponentEvents;

import javax.inject.Inject;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class CalendarScreen extends AbstractWindow {
    @Inject
    private CollectionDatasource<Task, UUID> tasksDs;
    @Inject
    private Calendar calendar;
    @Inject
    private Metadata metadata;

    @Override
    public void init(Map<String, Object> params) {
        calendar.addDateClickListener(event ->
                handleRangeSelect(event.getDate(), event.getDate()));

        calendar.addEventClickListener(event ->
                openEditor(event.getEntity(), WindowManager.OpenType.DIALOG)
                        .addCloseWithCommitListener(() -> tasksDs.refresh()));

        com.vaadin.ui.Calendar vaadinCalendar = (com.vaadin.ui.Calendar) WebComponentsHelper.unwrap(calendar);
        vaadinCalendar.setHandler((CalendarComponentEvents.RangeSelectHandler) event ->
                handleRangeSelect(event.getStart(), event.getEnd()));
    }

    private void handleRangeSelect(Date startDate, Date endDate) {
        Task newTask = metadata.create(Task.class);
        newTask.setStartDate(startDate);
        newTask.setEndDate(endDate);
        openEditor(newTask, WindowManager.OpenType.DIALOG)
                .addCloseWithCommitListener(() -> tasksDs.refresh());
    }
}