package executor;

public interface InterfaceTaskScheduler {

    boolean scheduleTask(TaskAction task);

    void shutdown();

    void mostrarStoredSchedules();

}
