package com.ssi.traversal;


import com.ssi.traversal.reporters.Reporter;
import com.ssi.traversal.traversers.Directory;
import com.ssi.traversal.traversers.DirectoryTraverser;
import com.ssi.traversal.traversers.TraverseStrategy;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TraversalTests {


    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void testTraversal() throws IOException {

        TraverseStrategy mockedStrategy = mock(TraverseStrategy.class);
        Reporter mockedReporter = mock(Reporter.class);

        File root = testFolder.getRoot();
        File x = testFolder.newFile("x");
        File a = testFolder.newFolder("a");
        File b = testFolder.newFolder("b");

        DirectoryTraverser dt = new DirectoryTraverser(mockedStrategy, mockedReporter);
        dt.run(root);

        verify(mockedStrategy, times(3)).enter(any(Directory.class));

    }



}
