package ch.cyberduck.core.editor;

/*
 * Copyright (c) 2012 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import ch.cyberduck.core.Host;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.local.Application;
import ch.cyberduck.core.local.ApplicationFinder;
import ch.cyberduck.core.local.ApplicationFinderFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FSEventWatchEditorFactory extends EditorFactory {

    private final Set<Application> editors = new HashSet<>();
    private final ApplicationFinder finder = ApplicationFinderFactory.get();

    public FSEventWatchEditorFactory() {
        this.add(new Application("com.apple.TextEdit", "TextEdit"));
        this.add(new Application("com.apple.Xcode", "Xcode"));
        this.add(new Application("com.apple.dt.Xcode", "Xcode"));
        this.add(new Application("de.codingmonkeys.SubEthaEdit", "SubEthaEdit"));
        this.add(new Application("com.barebones.bbedit", "BBEdit"));
        this.add(new Application("com.barebones.textwrangler", "TextWrangler"));
        this.add(new Application("com.macromates.textmate", "TextMate"));
        this.add(new Application("com.macromates.TextMate.preview", "TextMate 2"));
        this.add(new Application("com.sublimetext.2", "Sublime Text 2"));
        this.add(new Application("com.sublimetext.3", "Sublime Text 3"));
        this.add(new Application("com.github.atom", "Atom"));
        this.add(new Application("com.transtex.texeditplus", "Tex-Edit Plus"));
        this.add(new Application("jp.co.artman21.JeditX", "Jedit X"));
        this.add(new Application("net.mimikaki.mi", "mi"));
        this.add(new Application("org.smultron.Smultron", "Smultron"));
        this.add(new Application("org.fraise.Fraise", "Fraise"));
        this.add(new Application("com.aynimac.CotEditor", "CotEditor"));
        this.add(new Application("com.coteditor.CotEditor", "CotEditor"));
        this.add(new Application("com.macrabbit.cssedit", "CSSEdit"));
        this.add(new Application("com.talacia.Tag", "Tag"));
        this.add(new Application("org.skti.skEdit", "skEdit"));
        this.add(new Application("com.cgerdes.ji", "JarInspector"));
        this.add(new Application("com.optima.PageSpinner", "PageSpinner"));
        this.add(new Application("com.hogbaysoftware.WriteRoom", "WriteRoom"));
        this.add(new Application("org.vim.MacVim", "MacVim"));
        this.add(new Application("com.forgedit.ForgEdit", "ForgEdit"));
        this.add(new Application("com.tacosw.TacoHTMLEdit", "Taco HTML Edit"));
        this.add(new Application("com.macrabbit.Espresso", "Espresso"));
        this.add(new Application("net.experiya.ScinteX", "ScinteX"));
        this.add(new Application("com.microsoft.VSCode", "Visual Studio Code"));
        this.add(new Application("com.panic.Nova", "nova"));
        this.add(new Application("io.brackets.appshell", "Brackets"));
    }

    private void add(final Application application) {
        if(finder.isInstalled(application)) {
            editors.add(application);
        }
    }

    @Override
    public List<Application> getConfigured() {
        return new ArrayList<>(editors);
    }

    @Override
    public Editor create(final Host host, final Path file, final ProgressListener listener) {
        return new FSEventWatchEditor(host, file, listener);
    }
}
