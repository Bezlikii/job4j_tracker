package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpDescNameDescPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNameDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByIncNameAndIncPriority() {
        Comparator<Job> cmpIncNameIncPriority = new JobIncByName().thenComparing(new JobIncByPriority());
        int rsl = cmpIncNameIncPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityWithEqualNames() {
        Comparator<Job> cmpDescNameDescPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNameDescPriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorIncByName() {
        Comparator<Job> cmpIncName = new JobIncByName();
        int rsl = cmpIncName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int rsl = cmpDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorIncByPriority() {
        Comparator<Job> cmpIncPriority = new JobIncByPriority();
        int rsl = cmpIncPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}