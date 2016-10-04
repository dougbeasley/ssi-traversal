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

        Directory root = new Directory(testFolder.getRoot(), 0);
        File x = testFolder.newFile("x");
        Directory a = new Directory(testFolder.newFolder("a"), 1);
        Directory b = new Directory(testFolder.newFolder("b"), 1);

        when(mockedStrategy.peek()).thenReturn(root).thenReturn(a).thenReturn(b).thenReturn(null);
        when(mockedStrategy.leave()).thenReturn(root).thenReturn(a).thenReturn(b).thenReturn(null);

        DirectoryTraverser dt = new DirectoryTraverser(mockedStrategy, mockedReporter);
        dt.run(testFolder.getRoot());

        verify(mockedStrategy, times(3)).enter(any(Directory.class));
        verify(mockedReporter, times(4)).report(any(File.class), any(Integer.class));

    }



}
