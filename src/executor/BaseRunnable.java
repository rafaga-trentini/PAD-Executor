package executor;

import java.io.Serializable;

public class BaseRunnable implements Runnable, Serializable {

    protected final TaskAction taskAction;
    protected final InterfaceTaskStorage taskStorage;

    protected Runnable runnable;

    public BaseRunnable(TaskAction task, InterfaceTaskStorage taskStorage) {
        this.taskAction = task;
        this.taskStorage = taskStorage;
    }

    public BaseRunnable(TaskAction task, InterfaceTaskStorage taskStorage, Runnable runnable) {
        this(task, taskStorage);
        this.runnable = runnable;
    }

    protected void cleanTask() {
        if (this.taskAction.isRunOnce()) {
            this.taskStorage.mostrarTask(this.taskAction.getId());
        }
    }

    @Override
    public void run() {
        if (this.runnable != null) {
            this.runnable.run();
            this.cleanTask();
        }
    }
}
