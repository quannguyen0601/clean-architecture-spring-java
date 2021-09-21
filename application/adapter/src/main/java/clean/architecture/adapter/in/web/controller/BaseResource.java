package clean.architecture.adapter.in.web.controller;

public interface BaseResource<I,O> {
     O exec(I input);
}
