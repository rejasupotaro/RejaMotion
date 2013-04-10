
SHELL = /bin/sh

# V=0 quiet, V=1 verbose.  other values don't work.
V = 0
Q1 = $(V:1=)
Q = $(Q1:0=@)
ECHO1 = $(V:1=@:)
ECHO = $(ECHO1:0=@echo)

#### Start of system configuration section. ####

srcdir = .
topdir = $(includedir)/$(RUBY_VERSION_NAME)
hdrdir = $(includedir)/$(RUBY_VERSION_NAME)
arch_hdrdir = $(rubyhdrdir)/$(arch)
PATH_SEPARATOR = :
VPATH = $(srcdir):$(arch_hdrdir)/ruby:$(hdrdir)/ruby
prefix = $(DESTDIR)/Users/ken/.rbenv/versions/2.0.0-p0
rubysitearchprefix = $(rubylibprefix)/$(sitearch)
rubyarchprefix = $(rubylibprefix)/$(arch)
rubylibprefix = $(libdir)/$(RUBY_BASE_NAME)
exec_prefix = $(prefix)
vendorarchhdrdir = $(vendorhdrdir)/$(sitearch)
sitearchhdrdir = $(sitehdrdir)/$(sitearch)
rubyarchhdrdir = $(rubyhdrdir)/$(arch)
vendorhdrdir = $(rubyhdrdir)/vendor_ruby
sitehdrdir = $(rubyhdrdir)/site_ruby
rubyhdrdir = $(includedir)/$(RUBY_VERSION_NAME)
vendorarchdir = $(vendorlibdir)/$(sitearch)
vendorlibdir = $(vendordir)/$(ruby_version)
vendordir = $(rubylibprefix)/vendor_ruby
sitearchdir = $(sitelibdir)/$(sitearch)
sitelibdir = $(sitedir)/$(ruby_version)
sitedir = $(rubylibprefix)/site_ruby
rubyarchdir = $(rubylibdir)/$(arch)
rubylibdir = $(rubylibprefix)/$(ruby_version)
sitearchincludedir = $(includedir)/$(sitearch)
archincludedir = $(includedir)/$(arch)
sitearchlibdir = $(libdir)/$(sitearch)
archlibdir = $(libdir)/$(arch)
ridir = $(datarootdir)/$(RI_BASE_NAME)
mandir = $(datarootdir)/man
localedir = $(datarootdir)/locale
libdir = $(exec_prefix)/lib
psdir = $(docdir)
pdfdir = $(docdir)
dvidir = $(docdir)
htmldir = $(docdir)
infodir = $(datarootdir)/info
docdir = $(datarootdir)/doc/$(PACKAGE)
oldincludedir = $(DESTDIR)/usr/include
includedir = $(prefix)/include
localstatedir = $(prefix)/var
sharedstatedir = $(prefix)/com
sysconfdir = $(prefix)/etc
datadir = $(datarootdir)
datarootdir = $(prefix)/share
libexecdir = $(exec_prefix)/libexec
sbindir = $(exec_prefix)/sbin
bindir = $(exec_prefix)/bin
archdir = $(rubyarchdir)


CC = clang
CXX = g++
LIBRUBY = $(LIBRUBY_A)
LIBRUBY_A = lib$(RUBY_SO_NAME)-static.a
LIBRUBYARG_SHARED = 
LIBRUBYARG_STATIC = -l$(RUBY_SO_NAME)-static
empty =
OUTFLAG = -o $(empty)
COUTFLAG = -o $(empty)

RUBY_EXTCONF_H = 
cflags   =  $(optflags) $(debugflags) $(warnflags)
optflags = -O3
debugflags = -ggdb
warnflags = -Wall -Wextra -Wno-unused-parameter -Wno-parentheses -Wno-long-long -Wno-missing-field-initializers -Wunused-variable -Wpointer-arith -Wwrite-strings -Wdeclaration-after-statement -Wshorten-64-to-32 -Wimplicit-function-declaration
CFLAGS   = -fno-common   -Wno-error=shorten-64-to-32 -pipe $(ARCH_FLAG)
INCFLAGS = -I. -I$(arch_hdrdir) -I$(hdrdir)/ruby/backward -I$(hdrdir) -I$(srcdir)
DEFS     = 
CPPFLAGS = -DHAVE_ZLIB_H -DHAVE_FSEEKO -DHAVE_FTELLO -DHAVE_MKSTEMP -I'/Users/ken/.rbenv/versions/2.0.0-p0/include'  -D_XOPEN_SOURCE -D_DARWIN_C_SOURCE -D_DARWIN_UNLIMITED_SELECT -D_REENTRANT $(DEFS) $(cppflags)
CXXFLAGS = $(CFLAGS) $(cxxflags)
ldflags  = -L. -L'/Users/ken/.rbenv/versions/2.0.0-p0/lib' 
dldflags = -Wl,-undefined,dynamic_lookup -Wl,-multiply_defined,suppress 
ARCH_FLAG = 
DLDFLAGS = $(ldflags) $(dldflags) $(ARCH_FLAG)
LDSHARED = $(CC) -dynamic -bundle
LDSHAREDXX = $(CXX) -dynamic -bundle
AR = ar
EXEEXT = 

RUBY_INSTALL_NAME = ruby
RUBY_SO_NAME = ruby
RUBYW_INSTALL_NAME = 
RUBY_VERSION_NAME = $(RUBY_BASE_NAME)-$(ruby_version)
RUBYW_BASE_NAME = rubyw
RUBY_BASE_NAME = ruby

arch = x86_64-darwin12.2.1
sitearch = $(arch)
ruby_version = 2.0.0
ruby = $(bindir)/ruby
RUBY = $(ruby)
ruby_headers = $(hdrdir)/ruby.h $(hdrdir)/ruby/defines.h $(arch_hdrdir)/ruby/config.h

RM = rm -f
RM_RF = $(RUBY) -run -e rm -- -rf
RMDIRS = rmdir -p
MAKEDIRS = mkdir -p
INSTALL = /usr/bin/install -c
INSTALL_PROG = $(INSTALL) -m 0755
INSTALL_DATA = $(INSTALL) -m 644
COPY = cp
TOUCH = exit >

#### End of system configuration section. ####

preload = 

libpath = . $(libdir)
LIBPATH =  -L. -L$(libdir)
DEFFILE = 

CLEANFILES = mkmf.log
DISTCLEANFILES = 
DISTCLEANDIRS = 

extout = 
extout_prefix = 
target_prefix = 
LOCAL_LIBS = 
LIBS =  -lz  -lpthread -ldl -lobjc 
ORIG_SRCS = mkstemp.c tmpfile.c zip_add.c zip_add_dir.c zip_close.c zip_crypt.c zip_delete.c zip_dirent.c zip_entry_free.c zip_entry_new.c zip_err_str.c zip_error.c zip_error_clear.c zip_error_get.c zip_error_get_sys_type.c zip_error_strerror.c zip_error_to_str.c zip_fclose.c zip_file_error_clear.c zip_file_error_get.c zip_file_get_offset.c zip_file_strerror.c zip_fopen.c zip_fopen_index.c zip_fread.c zip_free.c zip_get_archive_comment.c zip_get_file_comment.c zip_get_name.c zip_get_num_files.c zip_memdup.c zip_name_locate.c zip_new.c zip_open.c zip_rename.c zip_replace.c zip_set_archive_comment.c zip_set_file_comment.c zip_set_name.c zip_source_buffer.c zip_source_file.c zip_source_filep.c zip_source_free.c zip_source_function.c zip_source_zip.c zip_stat.c zip_stat_index.c zip_stat_init.c zip_strerror.c zip_unchange.c zip_unchange_all.c zip_unchange_archive.c zip_unchange_data.c zipruby.c zipruby_archive.c zipruby_error.c zipruby_file.c zipruby_stat.c zipruby_zip.c zipruby_zip_source_io.c zipruby_zip_source_proc.c
SRCS = $(ORIG_SRCS) 
OBJS = mkstemp.o tmpfile.o zip_add.o zip_add_dir.o zip_close.o zip_crypt.o zip_delete.o zip_dirent.o zip_entry_free.o zip_entry_new.o zip_err_str.o zip_error.o zip_error_clear.o zip_error_get.o zip_error_get_sys_type.o zip_error_strerror.o zip_error_to_str.o zip_fclose.o zip_file_error_clear.o zip_file_error_get.o zip_file_get_offset.o zip_file_strerror.o zip_fopen.o zip_fopen_index.o zip_fread.o zip_free.o zip_get_archive_comment.o zip_get_file_comment.o zip_get_name.o zip_get_num_files.o zip_memdup.o zip_name_locate.o zip_new.o zip_open.o zip_rename.o zip_replace.o zip_set_archive_comment.o zip_set_file_comment.o zip_set_name.o zip_source_buffer.o zip_source_file.o zip_source_filep.o zip_source_free.o zip_source_function.o zip_source_zip.o zip_stat.o zip_stat_index.o zip_stat_init.o zip_strerror.o zip_unchange.o zip_unchange_all.o zip_unchange_archive.o zip_unchange_data.o zipruby.o zipruby_archive.o zipruby_error.o zipruby_file.o zipruby_stat.o zipruby_zip.o zipruby_zip_source_io.o zipruby_zip_source_proc.o
HDRS = $(srcdir)/tmpfile.h $(srcdir)/zip.h $(srcdir)/zipint.h $(srcdir)/zipruby.h $(srcdir)/zipruby_archive.h $(srcdir)/zipruby_error.h $(srcdir)/zipruby_file.h $(srcdir)/zipruby_stat.h $(srcdir)/zipruby_zip.h $(srcdir)/zipruby_zip_source_io.h $(srcdir)/zipruby_zip_source_proc.h
TARGET = zipruby
TARGET_NAME = zipruby
TARGET_ENTRY = Init_$(TARGET_NAME)
DLLIB = $(TARGET).bundle
EXTSTATIC = 
STATIC_LIB = 

BINDIR        = $(bindir)
RUBYCOMMONDIR = $(sitedir)$(target_prefix)
RUBYLIBDIR = /Users/ken/develop/projects/Rejamotion/RejaMotionServer/vendor/bundle/ruby/2.0.0/gems/zipruby-0.3.6/lib$(target_prefix)
RUBYARCHDIR = /Users/ken/develop/projects/Rejamotion/RejaMotionServer/vendor/bundle/ruby/2.0.0/gems/zipruby-0.3.6/lib$(target_prefix)
HDRDIR        = $(rubyhdrdir)/ruby$(target_prefix)
ARCHHDRDIR    = $(rubyhdrdir)/$(arch)/ruby$(target_prefix)

TARGET_SO     = $(DLLIB)
CLEANLIBS     = $(TARGET).bundle 
CLEANOBJS     = *.o  *.bak

all:    $(DLLIB)
static: $(STATIC_LIB)
.PHONY: all install static install-so install-rb
.PHONY: clean clean-so clean-static clean-rb

clean-static::
clean-rb-default::
clean-rb::
clean-so::
clean: clean-so clean-static clean-rb-default clean-rb
		-$(Q)$(RM) $(CLEANLIBS) $(CLEANOBJS) $(CLEANFILES)

distclean-rb-default::
distclean-rb::
distclean-so::
distclean-static::
distclean: clean distclean-so distclean-static distclean-rb-default distclean-rb
		-$(Q)$(RM) Makefile $(RUBY_EXTCONF_H) conftest.* mkmf.log
		-$(Q)$(RM) core ruby$(EXEEXT) *~ $(DISTCLEANFILES)
		-$(Q)$(RMDIRS) $(DISTCLEANDIRS) 2> /dev/null || true

realclean: distclean
install: install-so install-rb

install-so: $(DLLIB)
	$(INSTALL_PROG) $(DLLIB) $(RUBYARCHDIR)
clean-static::
	-$(Q)$(RM) $(STATIC_LIB)
install-rb: pre-install-rb install-rb-default
install-rb-default: pre-install-rb-default
pre-install-rb: Makefile
pre-install-rb-default: Makefile
pre-install-rb-default:
	$(ECHO) installing default zipruby libraries
./.RUBYARCHDIR.time:
	$(Q) $(MAKEDIRS) $(RUBYARCHDIR)
	$(Q) $(TOUCH) $@

site-install: site-install-so site-install-rb
site-install-so: install-so
site-install-rb: install-rb

.SUFFIXES: .c .m .cc .mm .cxx .cpp .C .o

.cc.o:
	$(ECHO) compiling $(<)
	$(Q) $(CXX) $(INCFLAGS) $(CPPFLAGS) $(CXXFLAGS) $(COUTFLAG)$@ -c $<

.mm.o:
	$(ECHO) compiling $(<)
	$(Q) $(CXX) $(INCFLAGS) $(CPPFLAGS) $(CXXFLAGS) $(COUTFLAG)$@ -c $<

.cxx.o:
	$(ECHO) compiling $(<)
	$(Q) $(CXX) $(INCFLAGS) $(CPPFLAGS) $(CXXFLAGS) $(COUTFLAG)$@ -c $<

.cpp.o:
	$(ECHO) compiling $(<)
	$(Q) $(CXX) $(INCFLAGS) $(CPPFLAGS) $(CXXFLAGS) $(COUTFLAG)$@ -c $<

.C.o:
	$(ECHO) compiling $(<)
	$(Q) $(CXX) $(INCFLAGS) $(CPPFLAGS) $(CXXFLAGS) $(COUTFLAG)$@ -c $<

.c.o:
	$(ECHO) compiling $(<)
	$(Q) $(CC) $(INCFLAGS) $(CPPFLAGS) $(CFLAGS) $(COUTFLAG)$@ -c $<

.m.o:
	$(ECHO) compiling $(<)
	$(Q) $(CC) $(INCFLAGS) $(CPPFLAGS) $(CFLAGS) $(COUTFLAG)$@ -c $<

$(DLLIB): $(OBJS) Makefile
	$(ECHO) linking shared-object $(DLLIB)
	-$(Q)$(RM) $(@)
	$(Q) $(LDSHARED) -o $@ $(OBJS) $(LIBPATH) $(DLDFLAGS) $(LOCAL_LIBS) $(LIBS)
	$(Q) test -z '$(RUBY_CODESIGN)' || codesign -s '$(RUBY_CODESIGN)' -f $@



$(OBJS): $(HDRS) $(ruby_headers)
