package za.co.dvt.android.showcase.utils;


import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulersOverrideRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxAndroidPlugins.reset();
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull final Callable<Scheduler> schedulerCallable) throws Exception {
                        return Schedulers.trampoline();
                    }
                });

                RxJavaPlugins.reset();
                RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull final Scheduler scheduler) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
                RxJavaPlugins.setComputationSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull final Scheduler scheduler) throws Exception {
                        return Schedulers.trampoline();
                    }
                });

                base.evaluate();

                RxAndroidPlugins.reset();
                RxJavaPlugins.reset();
            }
        };
    }
}